package br.com.cwi.crescer.maven;

import org.junit.Assert;
import org.junit.Test;

public class MatematicaTeste {
		@Test
		public void DeveSomarNumerosPositivos(){
			int resultado = new Matematica().somar(2, 2);
			Assert.assertEquals(4, resultado);
		}
}
