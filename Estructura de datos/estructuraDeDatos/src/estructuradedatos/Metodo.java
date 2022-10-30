package estructuradedatos;
public class Metodo {
    
    Object cola [] = new Object[20];
    int contador = 0;
    
    public void Push (String x){
    
        if (contador<20){
        
            cola[contador]= x;
            contador++;
           
        }
    }
    
    public void pop(){
    
        if (contador>0){
       
            cola[0]=null;
            for (int z=1; z<contador; z++)
                cola[z-1]=cola[z];

        }
    
       contador--; 
    }
    
    public String VerCola(){
    
        String v="";
        if(contador==0){
           
            v="No hay Elementos  :) ";
        }
        
        else {
        
            for(int o=0; o<contador;o++)
            v+=("Elemento: "+(o+1)+" --> "+cola[o]+ "\n" );   
        }
        
        return v;
    }
    public String Elementos(){
    
        String elementos="";
        elementos = (" "+contador);
        return elementos;
       
    }
    
    public String EstaLlena (){
    
        String llena="";
        if(contador==0){
        
            llena="Vacia";
        }
        else{
        
            llena="No esta Llena";
        }
     return llena;   
    }
    
    public String EstaVacia (){
    
        String vacia="";
        if(contador==20){
        
            vacia="Vacia";
        }
        else{
        
            vacia="No esta Vacia";
        }
     return vacia;   
    }
    
    public String Primero (){
    
        String primero="";
        if(cola[0]!=null){
        
            primero=(" "+cola[0]);
        }
        else{
        
            primero=("No hay Elementos");
        }
     return primero;   
    }
    
        public String Ultimo (){
    
        String ul="";
        if(cola[0]!=null){
        
            ul=(" "+cola[contador-1]);
        }
        else{
           ul=("No hay Elementos");           
        }
     return ul;   
    }
        
        public void vaciarCola(){
        
            for(int t=contador-1; t>=0; t--)
            cola[t]=null;    
            contador=0;    
        }
}
