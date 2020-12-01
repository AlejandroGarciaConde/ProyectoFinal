package tankes;
public class VariableC {
  private boolean vc;
  VariableC(){
     vc = false; // false abierta, true cerrada
  }

    public boolean isVcerr() {
        return vc;
    }

    public void setVcerr(boolean vc) {
        this.vc = vc;
    }
    public void cierra(){
        vc =true;
    }
    public void abre(){
        vc = false;
    }
}