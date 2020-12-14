public class Genero{
    private EnumGenero enumGenero;

    public Genero(EnumGenero enumGenero){
        this.enumGenero = enumGenero;
    }

    //Gets e Sets
    public EnumGenero getEnumGenero() {
        return this.enumGenero;
    }

    public void setEnumGenero(EnumGenero enumGenero) {
        if(!(enumGenero instanceof EnumGenero)){
            throw new IllegalArgumentException("APENAS ENUMGENERO");
        }
        else {
            this.enumGenero = enumGenero;
        }
    }

    //Métodos

    /*
    O método retornaDados() retorna, em Sring, o item correspondente ao ENUM da instância Gênero.
     */
    public String retornaDados(){
        return "Genero: " + this.enumGenero.toString();
    }

}