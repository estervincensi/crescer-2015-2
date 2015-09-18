
public class dataTerceiraEra
{
    private int dia, mes, ano;

    public int getDia(){
        return this.dia;
    }

    public int getAno(){
        return this.ano;
    }

    public int getMes(){
        return this.mes;
    }

    public dataTerceiraEra(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public boolean ehBissexto(){
        return (this.ano%4==0 && this.ano%100!=0) || this.ano%400==0 ? true : false;
    }
    
    public boolean equals(Object obj){
        dataTerceiraEra dt = (dataTerceiraEra)obj;
        return this.dia==dt.getDia() && this.mes==dt.getMes() && this.ano==dt.getAno();
    }
}
