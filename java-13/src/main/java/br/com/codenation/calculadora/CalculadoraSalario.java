package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		double salarioFinal;

		if (salarioBase <= 1039.00) { salarioFinal = 0.0; }

		else { salarioFinal = calcularIRRF(calcularInss(salarioBase)); }

		return Math.round(salarioFinal);
	}

	private double calcularInss(double salarioBase) {
		double salarioInss;

		if (salarioBase <= 1500.00) { salarioInss = salarioBase * 0.92; } // 8%

		else if (salarioBase <= 4000.00) { salarioInss = salarioBase * 0.91; } // 9%

		else { salarioInss = salarioBase * 0.89; } // 11%

		return salarioInss;
	}

	public double calcularIRRF(double salarioInss) {
		double salarioIRRF;

		if (salarioInss <= 3000.00) { salarioIRRF = salarioInss; } // ISENTO

		else if (salarioInss <= 6000.00) { salarioIRRF = salarioInss * 0.925; } // 7.5%

		else { salarioIRRF = salarioInss * 0.85; } // 15%

		return salarioIRRF;
	}

}
