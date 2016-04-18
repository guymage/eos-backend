package net.guymage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import model.joueur.CodeHabilitation;
import net.guymage.model.joueur.JoueurEntity;
import net.guymage.repository.joueur.JoueurRepository;

@Configuration
public class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

	@Autowired
	private JoueurRepository joueurDAO;

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(userDetailsService())
		.passwordEncoder(passwordEncoder());
	}

	@Bean
	UserDetailsService userDetailsService() {
		return new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String nom) throws UsernameNotFoundException {
				JoueurEntity joueur = joueurDAO.findByNom(nom);

				if (joueur != null) {
					// Ajout des habilitations
					List<GrantedAuthority> authorities = new ArrayList<>();
					if(joueur.getHabilitations() != null){
						for(CodeHabilitation habilitation : joueur.getHabilitations()){
							authorities.addAll(AuthorityUtils.createAuthorityList(habilitation.name()));
						}
					}

					return new User(nom, joueur.getPassword(), joueur.getActive(), joueur.getActive(),
							joueur.getActive(), joueur.getActive(), authorities);
				} else {
					throw new UsernameNotFoundException("Joueur introuvable: '" + nom + "'");
				}
			}
		};
	};

	/**
	 * @return Méthode d'encryption du password
	 */
	@Bean
	Md5PasswordEncoder passwordEncoder(){
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		return encoder;
	};

}
