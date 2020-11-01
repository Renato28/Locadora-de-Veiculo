package br.com.stefanini.maratonadev.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import br.com.stefanini.maratonadev.dto.CarroDto;
import br.com.stefanini.maratonadev.dto.ClienteDto;
import br.com.stefanini.maratonadev.model.Carro;
import br.com.stefanini.maratonadev.model.Cliente;
import br.com.stefanini.maratonadev.model.StatusAluguel;
import br.com.stefanini.maratonadev.service.CarroService;
import br.com.stefanini.maratonadev.service.ClienteService;

/**
 * 
 * @author Renato Nobrega
 * @version 0.1.0
 * @created 01/11/2020 on 15:42
 *
 */

@Path("carro")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CarroRest {

	@Inject
	private CarroService carroService;

	@Inject
	private ClienteService clienteService;

	@GET
	@Operation(summary = "Listar carros", description = "Listar de carros com ano de compra, marca, modelo e placa")
	@APIResponse(responseCode = "201", description = "carro", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = CarroDto.class)) })
	public Response listar() {
		return Response.status(Response.Status.OK).build();
	}

	@POST
	@Path("")
	@Operation(summary = "Cadastrar um carro", description = "Cadastrar um carro")
	@APIResponse(responseCode = "201", description = "carro", content = {
			@Content(mediaType = "Application/json", schema = @Schema(implementation = CarroDto.class)) })
	public Response cadastrar(CarroDto dto) {
		carroService.cadastrar(dto);
		return Response.status(Response.Status.CREATED).build();
	}
	
	@DELETE
	@Path("/{placa}")
	@Operation(summary = "Excluir um carro", description = "Excluir um carro")
	@APIResponse(responseCode = "202", description = "carro", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CarroDto.class))})
	public Response excluir(@PathParam("placa") String placa) {
		carroService.excluir(placa);
		return Response.status(Response.Status.ACCEPTED).build();
	}
	
	public void alugar(Carro carro, Cliente cliente) {
		if(carro.getStatus().equals(StatusAluguel.DISPONIVEL)) {
			
			ClienteDto clienteDto = new ClienteDto();
			clienteDto.setId(cliente.getId());
			clienteDto.setNome(cliente.getNome());
			clienteDto.setCpf(cliente.getCpf());
			clienteDto.setEmail(cliente.getEmail());
			clienteDto.setBairro(cliente.getBairro());
			clienteDto.setLogradouro(cliente.getLogradouro());
			clienteDto.setComplemento(cliente.getComplemento());
			clienteDto.setCidade(cliente.getCidade());
			clienteDto.setUf(cliente.getUf());
			clienteDto.setContato(cliente.getContato());
			
			clienteService.cadastrar(clienteDto);
		}
		
	}
	
	
}
