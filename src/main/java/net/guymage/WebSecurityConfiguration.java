package net.guymage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import model.joueur.CodeHabilitation;
import net.guymage.dao.joueur.JoueurRepository;
import net.guymage.model.joueur.JoueurEntity;

@Configuration
public class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

	@Autowired
	private JoueurRepository joueurDAO;

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}

	@Bean
	UserDetailsService userDetailsService() {
		return new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String nom) throws UsernameNotFoundException {
				JoueurEntity joueur = joueurDAO.findByNom(nom);

				// TODO cryptage du password en MD5

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

}
