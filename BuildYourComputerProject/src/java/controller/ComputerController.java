package controller;

import entity.Computer;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import manager.ComputerManager;

@Named(value = "computerController")
@RequestScoped
public class ComputerController {

    @Inject
    ComputerManager cm;

    private String chassi;
    private String gpu;
    private String cpu;
    private String ssd;
    private String psu;
    private String motherboard;
    private String internalMemory;
    private double price;
    private List<Computer> allComputers;

    @PostConstruct
    public void fillArray() {
        this.allComputers = cm.getAllComputers();
    }
    
    public void submit() {
        getTotalPrice();
        getRefinedStrings();
        Computer c = new Computer(chassi, motherboard, cpu, gpu, psu, ssd, internalMemory, price);
        cm.addComputer(c);
    }

    public void getTotalPrice() {
        addPrice(getChassi());
        addPrice(getMotherboard());
        addPrice(getCpu());
        addPrice(getGpu());
        addPrice(getPsu());
        addPrice(getSsd());
        addPrice(getInternalMemory());
    }

    public void addPrice(String s) {
        if (s.length() > 2) {
            int x = s.indexOf("/");
            s = s.substring(x + 2, s.length() - 2);
            setPrice(getPrice() + Double.valueOf(s));
        }
    }

    public String refineString(String s) {
        int x = s.indexOf("/");
        return s.substring(0, x - 1);
    }

    public void getRefinedStrings() {
        setChassi(refineString(getChassi()));
        setMotherboard(refineString(getMotherboard()));
        setCpu(refineString(getCpu()));
        setGpu(refineString(getGpu()));
        setPsu(refineString(getPsu()));
        setSsd(refineString(getSsd()));
        setInternalMemory(refineString(getInternalMemory()));
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInternalMemory() {
        return internalMemory;
    }

    public void setInternalMemory(String internalMemory) {
        this.internalMemory = internalMemory;
    }

    public ComputerController() {

    }

    public ComputerManager getCm() {
        return cm;
    }

    public void setCm(ComputerManager cm) {
        this.cm = cm;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getSsd() {
        return ssd;
    }

    public void setSsd(String ssd) {
        this.ssd = ssd;
    }

    public String getPsu() {
        return psu;
    }

    public void setPsu(String psu) {
        this.psu = psu;
    }

    public String getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(String motherboard) {
        this.motherboard = motherboard;
    }

    public List<Computer> getAllComputers() {
        return allComputers;
    }

    public void setAllComputers(List<Computer> allComputers) {
        this.allComputers = allComputers;
    }

}
