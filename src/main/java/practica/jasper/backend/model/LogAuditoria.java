package practica.jasper.backend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "log_auditoria")
public class LogAuditoria {
	private Integer id;
	private Integer idUsuario;
	private Date fecha;
	private String tabla;
	private String valorAnterior;
	private String valorNuevo;
	private String ip;
	private String identificacionSession;
	private String tipoAccion;
	private String valorEnviado;
	private String valorRecibido;
	private Integer idtipo_hardware;
	private Integer idhardware;
	private Boolean tipoAcceso; // true = web
	private String hardwareSerie, usuarioEmail, tipoHardwareDescripcion;
	
	@Column(name = "valorNuevo")
	public String getValorNuevo() {
		return valorNuevo;
	}

	public void setValorNuevo(String valorNuevo) {
		this.valorNuevo = valorNuevo;
	}

	@Column(name = "ip")
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "identificacionSession")
	public String getIdentificacionSession() {
		return identificacionSession;
	}

	public void setIdentificacionSession(String maquinaSerial) {
		this.identificacionSession = maquinaSerial;
	}

	@Column(name = "tipoAccion")
	public String getTipoAccion() {
		return tipoAccion;
	}

	public void setTipoAccion(String tipoAccion) {
		this.tipoAccion = tipoAccion;
	}

	public LogAuditoria() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idlogauditoria")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "idusuario")
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Column(name = "fecha")
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Column(name = "tabla")
	public String getTabla() {
		return tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	@Column(name = "valorAnterior")
	public String getValorAnterior() {
		return valorAnterior;
	}

	public void setValorAnterior(String valorAnterior) {
		this.valorAnterior = valorAnterior;
	}

	@Column(name = "valorenviado")
	public String getValorEnviado() {
		return valorEnviado;
	}

	public void setValorEnviado(String valorEnviado) {
		this.valorEnviado = valorEnviado;
	}

	@Column(name = "valorrecibido")
	public String getValorRecibido() {
		return valorRecibido;
	}

	public void setValorRecibido(String valorRecibido) {
		this.valorRecibido = valorRecibido;
	}

	@Column(name = "idtipo_hardware")
	public Integer getIdtipo_hardware() {
		return idtipo_hardware;
	}

	public void setIdtipo_hardware(Integer idtipo_hardware) {
		this.idtipo_hardware = idtipo_hardware;
	}

	@Column(name = "idhardware")
	public Integer getIdhardware() {
		return idhardware;
	}

	public void setIdhardware(Integer idhardware) {
		this.idhardware = idhardware;
	}

	@Column(name = "tipoAcceso")
	public Boolean getTipoAcceso() {
		return tipoAcceso;
	}

	public void setTipoAcceso(Boolean tipoAcceso) {
		this.tipoAcceso = tipoAcceso;
	}
	@Column(name = "tipo_hardware_descripcion")
	public String getTipoHardwareDescripcion() {
		return tipoHardwareDescripcion;
	}

	public void setTipoHardwareDescripcion(String tipoHardware) {
		this.tipoHardwareDescripcion = tipoHardware;
	}
	
	@Column(name = "usuario_email")
	public String getUsuarioEmail() {
		return usuarioEmail;
	}

	public void setUsuarioEmail(String email) {
		this.usuarioEmail = email;
	}

	@Column(name = "hardware_serie")
	public String getHardwareSerie() {
		return hardwareSerie;
	}

	public void setHardwareSerie(String serie) {
		this.hardwareSerie = serie;
	}
	
	
	
	

}

