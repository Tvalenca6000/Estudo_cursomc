package com.tvalenca.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tvalenca.cursomc.domain.Categoria;
import com.tvalenca.cursomc.domain.Cidade;
import com.tvalenca.cursomc.domain.Cliente;
import com.tvalenca.cursomc.domain.Endereco;
import com.tvalenca.cursomc.domain.Estado;
import com.tvalenca.cursomc.domain.Pagamento;
import com.tvalenca.cursomc.domain.Pagamento_Com_Boleto;
import com.tvalenca.cursomc.domain.Pagamento_Com_Cartao;
import com.tvalenca.cursomc.domain.Pedido;
import com.tvalenca.cursomc.domain.Produto;
import com.tvalenca.cursomc.domain.enums.Estado_Pagamento;
import com.tvalenca.cursomc.domain.enums.Tipo_Cliente;
import com.tvalenca.cursomc.repositories.Categoria_Repository;
import com.tvalenca.cursomc.repositories.Cidade_Repository;
import com.tvalenca.cursomc.repositories.Cliente_Repository;
import com.tvalenca.cursomc.repositories.Endereco_Repository;
import com.tvalenca.cursomc.repositories.Estado_Repository;
import com.tvalenca.cursomc.repositories.Pagamento_Repository;
import com.tvalenca.cursomc.repositories.Pedido_Repository;
import com.tvalenca.cursomc.repositories.Produto_Repository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private Categoria_Repository categoriaRepository;
	@Autowired
	private Produto_Repository produtoRepository;
	@Autowired
	private Estado_Repository estadoRepository;
	@Autowired
	private Cidade_Repository cidadeRepository;
	@Autowired
	private Cliente_Repository clienteRepository;
	@Autowired
	private Endereco_Repository enderecoRepository;
	@Autowired
	private Pedido_Repository pedidoRepository;
	@Autowired
	private Pagamento_Repository pagamentoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);

		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");

		Cidade c1 = new Cidade(null,"Uberlândia",est1);
		Cidade c2 = new Cidade(null,"São Paulo",est2);
		Cidade c3 = new Cidade(null,"Campinas",est2);

		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));

		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));

		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", Tipo_Cliente.PESSOAFISICA);

		cli1.getTelefones().addAll(Arrays.asList("27363323","93838393"));

		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy hh:mm");

		Pedido pedi1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido pedi2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);

		Pagamento pagto1 = new Pagamento_Com_Cartao(null,Estado_Pagamento.QUITADO,pedi1,6);
		pedi1.setPagamento(pagto1);

		Pagamento pagto2 = new Pagamento_Com_Boleto(null, Estado_Pagamento.PENDENTE, pedi2,sdf.parse("20/10/2017 00:00"),null);
		pedi2.setPagamento(pagto2);

		cli1.getPedidos().addAll(Arrays.asList(pedi1,pedi2));

		pedidoRepository.saveAll(Arrays.asList(pedi1,pedi2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));
	}

}
