package br.com.demospringboot.exception;


public class ExceptionDefault {	

	private ExceptionDefault() {}
	
	private String mensagem;
	private Integer status;
	private String detalhe;
	private Long timestamp;
	private String exceptionType;
	
	public String getMensagem() {
		return mensagem;
	}

	public Integer getStatus() {
		return status;
	}

	public String getDetalhe() {
		return detalhe;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public String getExceptionType() {
		return exceptionType;
	}
	
	
	public static final class ResourceNotFoundExceptionBuilder{
		private String mensagem;
		private Integer status;
		private String detalhe;
		private Long timestamp;
		private String exceptionType;
		
		private ResourceNotFoundExceptionBuilder() {			
		}
		
		public static ResourceNotFoundExceptionBuilder newBuilder() {
			return new ResourceNotFoundExceptionBuilder();
		}
		
		public ResourceNotFoundExceptionBuilder mensagem(String men)	{
			this.mensagem = men;
			return this;
		}
		
		public ResourceNotFoundExceptionBuilder status(Integer stat)	{
			this.status = stat;
			return this;
		}
		
		public ResourceNotFoundExceptionBuilder detalhe(String det)	{
			this.detalhe = det;
			return this;
		}
		
		public ResourceNotFoundExceptionBuilder timestamp(Long tmp)	{
			this.timestamp = tmp;
			return this;
		}
		
		public ResourceNotFoundExceptionBuilder exceptionType(String ext)	{
			this.exceptionType = ext;
			return this;
		}
		
	}
	
}
