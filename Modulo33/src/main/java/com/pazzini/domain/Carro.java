// Declaração do pacote ao qual a classe pertence
package com.pazzini.domain;

// Importações de classes relacionadas à persistência e coleções
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// Declaração da classe de domínio Carro, mapeada como uma entidade JPA
@Entity
@Table(name = "TB_CARRO") // Especificação da tabela no banco de dados
public class Carro {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="carro_seq") // Configuração da geração automática de chaves primárias
	@SequenceGenerator(name="carro_seq", sequenceName="sq_carro", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "CHASSI", length = 30, nullable = false, unique = true) // Configuração da coluna "CHASSI" no banco de dados
	private String chassi;
	
	@Column(name = "COR", length = 30, nullable = false) // Configuração da coluna "COR"
	private String cor;
	
	@Column(name = "ANO_FABRICACAO", length = 5, nullable = false) // Configuração da coluna "ANO_FABRICACAO"
	private Long ano_fabricacao;
	
	@ManyToOne
	@JoinColumn(name = "id_marca_fk", // Configuração da chave estrangeira para a entidade Marca
			foreignKey = @ForeignKey(name = "fk_marca_carro"),
			referencedColumnName = "id", nullable = false)
	private Marca marca;
	
	@ManyToMany(cascade = {CascadeType.ALL}) // Configuração do relacionamento muitos para muitos com a entidade Acessorio
	@JoinTable(name = "TB_CARRO_ACESSORIO" ,
			   joinColumns = { @JoinColumn(name = "id_carro_fk")} ,
			   inverseJoinColumns = { @JoinColumn(name = "id_acessorio_fk") })
	private List<Acessorio> acessorios;

	// Construtor da classe Carro, inicializa a lista de acessórios
	public Carro() {
		this.acessorios = new ArrayList<Acessorio>();
	}
	
	// Método para adicionar um acessório à lista de acessórios do carro
	public void addAcessorio(Acessorio acessorio) {
		this.acessorios.add(acessorio);
	}
	
	// Métodos getters e setters para os campos da entidade

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Long getAno_fabricacao() {
		return ano_fabricacao;
	}

	public void setAno_fabricacao(Long ano_fabricacao) {
		this.ano_fabricacao = ano_fabricacao;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}
}
