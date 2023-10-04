package parametrizado;

public class Sueldo {
    public String descuento(int salario){
        if(salario < 0){
            return "dato invalido";
        } else {
            if(salario <= 2000){
                return ""+salario;
            } else if(salario > 4000){
                float newS = (float) (salario - (salario * 0.15));
                return "" + ((int)newS);
            } else {
                float newS = (float) (salario - (salario * 0.05));
                return "" + ((int)newS);
            }
        }
    }
}
