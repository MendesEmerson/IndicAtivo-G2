package br.com.empiricus.service.impl;


//BY THIAGOSILVA
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.empiricus.model.UserLoginPF;
import br.com.empiricus.repository.UserPFRepository;
import br.com.empiricus.service.UserPFService.UserrPFService;
import br.com.empiricus.springboot.exception.ResourceNotFoundException;


@Service
@Transactional
public class UserPFServiceImpl implements UserrPFService {

	private UserPFRepository userPFRepository;
	
	public UserPFServiceImpl(UserPFRepository userPFRepository) {
		super();
		this.userPFRepository = userPFRepository;
	}


	@Override
	public UserLoginPF saveUserPF(UserLoginPF userLoginPF) {
		return userPFRepository.save(userLoginPF);
	}


	@Override
	public java.util.List<UserLoginPF> getAllUserPF() {
		return userPFRepository.findAll();
	}


	@Override
	public UserLoginPF getUserPFById(long id) {
		return userPFRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Cliente", "Id", id));
	}


	@Override
	public UserLoginPF updateUserPF(UserLoginPF userLoginPF, long id) {
		// VERIFICAR SE O ID EXISTE DENTRO DO BD
		UserLoginPF existingUserLoginPF = userPFRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Cliente", "Id", id));
		
		existingUserLoginPF.setNome(userLoginPF.getNome());
		existingUserLoginPF.setSobreNome(userLoginPF.getSobreNome());
		existingUserLoginPF.setEmail(userLoginPF.getEmail());
		existingUserLoginPF.setCpf(userLoginPF.getCpf());
		existingUserLoginPF.setTelefone(userLoginPF.getTelefone());
		//SALVAR FUNCIONARIO EXISTENTE NO BD
		userPFRepository.save(existingUserLoginPF);
		return existingUserLoginPF;
		
		
	}
	
	

	@Override
	public void deleteUserPF(long id) {
		// VERIFICAR SE O ID EXISTE DENTRO DO BD
		userPFRepository.findById(id).orElseThrow(() -> 
							new ResourceNotFoundException("Cliente", "Id", id));
		userPFRepository.deleteById(id);
		
	}
	
	
	
}
