package glacialExpedition.models.explorers;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.suitcases.Carton;
import glacialExpedition.models.suitcases.Suitcase;

public abstract class BaseExplorer implements Explorer{
    private String name;
    private double energy;
    private Suitcase suitcase;

    protected BaseExplorer(String name, double energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.suitcase = new Carton();
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name==null||name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.EXPLORER_NAME_NULL_OR_EMPTY);
        }else {
            this.name = name;
        }
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    protected void setEnergy(double energy) {
        if (energy<0){
            throw new IllegalArgumentException(ExceptionMessages.EXPLORER_ENERGY_LESS_THAN_ZERO);
        }else {
            this.energy = energy;
        }
    }

    @Override
    public void search() {
        this.energy = Math.max(0, this.energy -15);
    }

    @Override
    public boolean canSearch() {
        return this.energy > 0;
    }
    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();

        info.append(String.format(ConstantMessages.FINAL_EXPLORER_NAME, this.name)).append(System.lineSeparator());
        info.append(String.format(ConstantMessages.FINAL_EXPLORER_ENERGY, this.energy)).append(System.lineSeparator());
        info.append("Suitcase exhibits: ");

        int exhibitsCount = this.suitcase.getExhibits().size();

        String suitcaseExhibit = exhibitsCount == 0
                ? "None"
                : String.join(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, this.getSuitcase().getExhibits());

        info.append(suitcaseExhibit);

        return info.toString().trim();
    }
    @Override
    public Suitcase getSuitcase() {
        return this.suitcase;
    }
}
