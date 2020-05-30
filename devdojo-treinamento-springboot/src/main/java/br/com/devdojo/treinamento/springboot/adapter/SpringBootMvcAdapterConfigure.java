package br.com.devdojo.treinamento.springboot.adapter;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class SpringBootMvcAdapterConfigure extends WebMvcConfigurerAdapter {
	
	private static int PAGINA = 0;
	private static int TOTAL_REGISTRO_POR_PAGINA = 20;
		
	// Alteração para alterar a paginação defalt do Jpa 
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();		
		resolver.setFallbackPageable(PageRequest.of(PAGINA, TOTAL_REGISTRO_POR_PAGINA));
		argumentResolvers.add(resolver);
	}
	
	public static int getTotalRegistrosPorPagina() {
		return TOTAL_REGISTRO_POR_PAGINA;
	}
}
