/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloVeo;

/**
 *
 * @author alrod
 */
public class VehiculoVo {

    private String vehPlaca, datId, catId, vehModelo, vehMarca, vehEstado, vehPrecio;

    public VehiculoVo(String vehPlaca, String datId, String catId, String vehModelo, String vehMarca, String vehEstado, String vehPrecio) {
        this.vehPlaca = vehPlaca;
        this.datId = datId;
        this.catId = catId;
        this.vehModelo = vehModelo;
        this.vehMarca = vehMarca;
        this.vehEstado = vehEstado;
        this.vehPrecio = vehPrecio;
    }

    public String getVehPlaca() {
        return vehPlaca;
    }

    public void setVehPlaca(String vehPlaca) {
        this.vehPlaca = vehPlaca;
    }

    public String getDatId() {
        return datId;
    }

    public void setDatId(String datId) {
        this.datId = datId;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getVehModelo() {
        return vehModelo;
    }

    public void setVehModelo(String vehModelo) {
        this.vehModelo = vehModelo;
    }

    public String getVehMarca() {
        return vehMarca;
    }

    public void setVehMarca(String vehMarca) {
        this.vehMarca = vehMarca;
    }

    public String getVehEstado() {
        return vehEstado;
    }

    public void setVehEstado(String vehEstado) {
        this.vehEstado = vehEstado;
    }

    public String getVehPrecio() {
        return vehPrecio;
    }

    public void setVehPrecio(String vehPrecio) {
        this.vehPrecio = vehPrecio;
    }

}
