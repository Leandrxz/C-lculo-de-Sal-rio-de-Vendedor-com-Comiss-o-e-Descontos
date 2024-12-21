import java.util.Scanner;

public class Vendedor {

    private float vendas;
    private float salario;
    private String nome;
    private int falta;

    public Vendedor(float v, float s, String n, int f) {
        this.vendas = v;
        this.salario = s;
        this.nome = n;
        this.falta = f;
    }

    public void setVendas(float v) {
        this.vendas = v;
    }

    public float getVendas() {
        return vendas;
    }

    public void setSalario(float s) {
        this.salario = s;
    }

    public float getSalario() {
        return salario;
    }

    public void setNome(String n) {
        this.nome = n;
    }

    public String getNome() {
        return nome;
    }

    public void setFalta(int f) {
        this.falta = f;
    }

    public int getFalta() {
        return falta;
    }

    public void imprimirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Salario Base: " + salario);
        System.out.println("Vendas: " + vendas);
        System.out.println("Faltas: " + falta);
    }

    public float calcularComissao() {
        if (vendas >= 1000 && vendas < 2000) {
            return vendas * 0.10f;
        } else if (vendas >= 2000) {
            return vendas * 0.15f;
        } else {
            return 0;
        }
    }

    public float descontoFalta() {
        return (salario / 30) * falta;
    }

    public float calcularSalarioFinal() {
        float comissao = calcularComissao();
        float desconto = descontoFalta();
        return salario + comissao - desconto;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do vendedor: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o salario base do vendedor: ");
        float salario = scanner.nextFloat();

        System.out.print("Digite o valor das vendas do vendedor: ");
        float vendas = scanner.nextFloat();

        System.out.print("Digite o numero de faltas do vendedor: ");
        int falta = scanner.nextInt();

        Vendedor vendedor1 = new Vendedor(vendas, salario, nome, falta);

        vendedor1.imprimirDados();

        System.out.println("Comissao: " + vendedor1.calcularComissao());
        System.out.println("Desconto por falta: " + vendedor1.descontoFalta());

        System.out.println("Salario final apos comissao e desconto: " + vendedor1.calcularSalarioFinal());

        scanner.close();
    }
}