package emoveisMODEL;

/**
 *
 * @author Wenderson
 */
public class Imovel {

    private String tipo_imovel;
    private int area_imovel;
    private String cor_imovel;
    private int qtd_comodos_imovel;
    private String endereco_imovel;
    private double valor_imovel;
    private boolean status_imovel;
    private int id_imovel;

    private Imovel(String tipo_imovel, int area_imovel, String cor_imovel,
            int qtd_comodos_imovel, String endereco_imovel, double valor_imovel,
            boolean status_imovel, int id_imovel) {

        this.tipo_imovel = tipo_imovel;
        this.area_imovel = area_imovel;
        this.cor_imovel = cor_imovel;
        this.qtd_comodos_imovel = qtd_comodos_imovel;
        this.endereco_imovel = endereco_imovel;
        this.valor_imovel = valor_imovel;
        this.status_imovel = status_imovel;
        this.id_imovel = id_imovel;
    }
    public String getTipo_imovel() {
        return tipo_imovel;
    }
    public int getArea_imovel() {
        return area_imovel;
    }
    public String getCor_imovel() {
        return cor_imovel;
    }
    public int getQtd_comodos_imovel() {
        return qtd_comodos_imovel;
    }
    public String getEndereco_imovel() {
        return endereco_imovel;
    }
    public double getValor_imovel() {
        return valor_imovel;
    }
    public boolean isStatus_imovel() {
        return status_imovel;
    }
    public int getId_imovel() {
        return id_imovel;
    }
    public static class ImovelBuilder {

        private String tipo_imovel;
        private int area_imovel;
        private String cor_imovel;
        private int qtd_comodos_imovel;
        private String endereco_imovel;
        private double valor_imovel;
        private boolean status_imovel;
        private int id_imovel;

        public ImovelBuilder() {
        }

        public ImovelBuilder tipo_imovel(String tipo_imovel) {
            this.tipo_imovel = tipo_imovel;
            return this;
        }

        public ImovelBuilder area_imovel(int area_imovel) {
            this.area_imovel = area_imovel;
            return this;
        }

        public ImovelBuilder cor_imovel(String cor_imovel) {
            this.cor_imovel = cor_imovel;
            return this;
        }

        public ImovelBuilder qtd_comodos_imovel(int qtd_comodos_imovel) {
            this.qtd_comodos_imovel = qtd_comodos_imovel;
            return this;
        }

        public ImovelBuilder endereco_imovel(String endereco_imovel) {
            this.endereco_imovel = endereco_imovel;
            return this;
        }

        public ImovelBuilder valor_imovel(Double valor_imovel) {
            this.valor_imovel = valor_imovel;
            return this;
        }

        public ImovelBuilder status_imovel(Boolean status_imovel) {
            this.status_imovel = status_imovel;
            return this;
        }

        public ImovelBuilder id_imovel(int id_imovel) {
            this.id_imovel = id_imovel;
            return this;
        }

        public Imovel build() {
            return new Imovel(this.tipo_imovel, this.area_imovel, this.cor_imovel,
                    this.qtd_comodos_imovel, this.endereco_imovel, this.valor_imovel,
                    this.status_imovel, this.id_imovel);
        }

    }

    @Override
    public String toString() {
        String end[] = endereco_imovel.split(",");
        endereco_imovel = "";
        for (String string : end) {

            endereco_imovel += string + "\n\t\t\t\t\t\t\t\t\t\t\t\t";
        }
        while (tipo_imovel.length() < 15) {
            tipo_imovel += " ";
        }

        String status = null;
        if (status_imovel) {
            status = "Disponível";
        } else {
            status = "Indisponível";
        }

        return (id_imovel + "\t" + tipo_imovel + "\t" + cor_imovel + "\t\t\t" + qtd_comodos_imovel + "\t\t" + " R$ " + valor_imovel + "\t" + status + "\t" + endereco_imovel).replace('.', ',');
    }

}
