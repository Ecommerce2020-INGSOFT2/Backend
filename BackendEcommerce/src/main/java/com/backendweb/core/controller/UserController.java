package com.backendweb.core.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backendweb.core.entity.Role;
import com.backendweb.core.entity.User;
import com.backendweb.core.model.ERole;
import com.backendweb.core.model.ModelUser;
import com.backendweb.core.payload.MessageResponse;
import com.backendweb.core.payload.SignupRequest;
import com.backendweb.core.repository.RoleRepository;
import com.backendweb.core.repository.UserRepository;
import com.backendweb.core.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class UserController {

	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	// Registrar nuevo usuario

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest()
					.body(new MessageResponse("Error: Este nombre de usuario ya está disponible!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Correo electrónico ya está en uso!"));
		}

		// Create new user's account
		User user = new User(null, signUpRequest.getUsername(), signUpRequest.getEmail(), null, null,
				encoder.encode(signUpRequest.getPassword()), null, null, null, null, null, null, null);

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "mod":
					Role modRole = roleRepository.findByName(ERole.ROLE_MERCHAND)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRole(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("Usuario registrado exitosamente!"));
	}

	/*
	 * @PostMapping("/agregaruser") public ModelUser addUser(@RequestBody ModelUser
	 * modelUser) { //user.setId(0);
	 * 
	 * //Este metodo guardará al usuario enviado userService.save(modelUser);
	 * 
	 * return modelUser;
	 * 
	 * }
	 */

	/*
	 * @PostMapping("/agregaruser") public ModelUser addUser(@RequestBody @Valid
	 * ModelUser modelUser) {
	 * 
	 * 
	 * if(result.hasErrors()) { baseAttributerForUserForm(model, user, TAB_FORM);
	 * }else { try { userService.createUser(user); baseAttributerForUserForm(model,
	 * new User(), TAB_LIST );
	 * 
	 * } catch (CustomeFieldValidationException cfve) {
	 * result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
	 * baseAttributerForUserForm(model, user, TAB_FORM ); }catch (Exception e) {
	 * model.addAttribute("formErrorMessage",e.getMessage());
	 * baseAttributerForUserForm(model, user, TAB_FORM ); } } return
	 * "user-form/user-view"; return modelUser;
	 * 
	 * //return userService.addUser(modelUser); }
	 */
}
