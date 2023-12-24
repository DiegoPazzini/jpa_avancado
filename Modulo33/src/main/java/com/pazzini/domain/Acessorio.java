// Declaração do pacote ao qual a classe pertence
package com.pazzini.domain;

// Importações de classes relacionadas à persistência e coleções
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// Declaração da classe de domínio Acessorio, mapeada como uma entidade JPA
@Entity
@Table(name = "TB_ACESSORIO") // Especificação da tabela no banco de dados
public class Acessorio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="acessorio_seq") // Configuração da geração automática de chaves primárias
	@SequenceGenerator(name="acessorio_seq", sequenceName="sq_acessorio", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "CODIGO", length = 100, nullable = false, unique = true) // Configuração da coluna "CODIGO" no banco de dados
	private String codigo;
	
	@Column(name = "CLASSIFICACAO", length = 100, nullable = false) // Configuração da coluna "CLASSIFICACAO"
	private String classificacao;
	
	@Column(name = "DETALHES_TECNICOS", length = 100, nullable = true) // Configuração da coluna "DETALHES_TECNICOS"
	private String detalhes_tecnicos;
	
	@ManyToMany(mappedBy = "acessorios") // Mapeamento da relação muitos para muitos com a entidade Carro
	private List<Carro> carros;

	// Métodos getters e setters para os campos da entidade

	// Método getter para o atributo 'id'
	public Long getId() {
		return id;
	}

	// Método setter para o atributo 'id'
	public void setId(Long id) {
		this.id = id;
	}

	// Método getter para o atributo 'codigo'
	public String getCodigo() {
		return codigo;
	}

	// Método setter para o atributo 'codigo'
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	// Método getter para o atributo 'classificacao'
	public String getClassificacao() {
		return classificacao;
	}

	// Método setter para o atributo 'classificacao'
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	// Método getter para o atributo 'detalhes_tecnicos'
	public String getDetalhes_tecnicos() {
		return detalhes_tecnicos;
	}

	// Método setter para o atributo 'detalhes_tecnicos'
	public void setDetalhes_tecnicos(String detalhes_tecnicos) {
		this.detalhes_tecnicos = detalhes_tecnicos;
	}

	// Método getter para o atributo 'carros'
	public List<Carro> getCarros() {
		return carros;
	}

	// Método setter para o atributo 'carros'
	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}
}
