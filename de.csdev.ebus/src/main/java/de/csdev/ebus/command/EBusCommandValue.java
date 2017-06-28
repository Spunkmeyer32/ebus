package de.csdev.ebus.command;

import java.math.BigDecimal;
import java.util.Map;

import de.csdev.ebus.cfg.datatypes.IEBusType;

public class EBusCommandValue implements IEBusValue {

    private String name;

    private String label;

    private IEBusType type;

    private BigDecimal min;

    private BigDecimal max;

    private BigDecimal factor;

    private Map<String, String> mapping;

    private String step;

    public Map<String, String> getMapping() {
        return mapping;
    }

    public void setMapping(Map<String, String> mapping) {
        this.mapping = mapping;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public BigDecimal getFactor() {
        return factor;
    }

    public void setFactor(BigDecimal factor) {
        this.factor = factor;
    }

    private Object defaultValue;

    public Object getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    // public void setDefaultValue(byte[] defaultValue) {
    // this.defaultValue = this.type.decode(defaultValue);
    // // this.defaultValue = defaultValue;
    // }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public IEBusType getType() {
        return type;
    }

    public void setType(IEBusType type) {
        this.type = type;
    }

    public BigDecimal getMin() {
        return min;
    }

    public void setMin(BigDecimal min) {
        this.min = min;
    }

    public BigDecimal getMax() {
        return max;
    }

    public void setMax(BigDecimal max) {
        this.max = max;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static EBusCommandValue getInstance(IEBusType type, byte[] data) {
        EBusCommandValue value = new EBusCommandValue();
        value.setType(type);
        value.setDefaultValue(data);
        return value;
    }

    public String toString() {
        return "EBusCommandValue [name=" + name + ", label=" + label + ", type=" + type + ", min=" + min + ", max="
                + max + ", factor=" + factor + ", mapping=" + mapping + ", step=" + step + ", defaultValue="
                + defaultValue + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((defaultValue == null) ? 0 : defaultValue.hashCode());
        result = prime * result + ((factor == null) ? 0 : factor.hashCode());
        result = prime * result + ((label == null) ? 0 : label.hashCode());
        result = prime * result + ((mapping == null) ? 0 : mapping.hashCode());
        result = prime * result + ((max == null) ? 0 : max.hashCode());
        result = prime * result + ((min == null) ? 0 : min.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((step == null) ? 0 : step.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        EBusCommandValue other = (EBusCommandValue) obj;
        if (defaultValue == null) {
            if (other.defaultValue != null) {
                return false;
            }
        } else if (!defaultValue.equals(other.defaultValue)) {
            return false;
        }
        if (factor == null) {
            if (other.factor != null) {
                return false;
            }
        } else if (!factor.equals(other.factor)) {
            return false;
        }
        if (label == null) {
            if (other.label != null) {
                return false;
            }
        } else if (!label.equals(other.label)) {
            return false;
        }
        if (mapping == null) {
            if (other.mapping != null) {
                return false;
            }
        } else if (!mapping.equals(other.mapping)) {
            return false;
        }
        if (max == null) {
            if (other.max != null) {
                return false;
            }
        } else if (!max.equals(other.max)) {
            return false;
        }
        if (min == null) {
            if (other.min != null) {
                return false;
            }
        } else if (!min.equals(other.min)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (step == null) {
            if (other.step != null) {
                return false;
            }
        } else if (!step.equals(other.step)) {
            return false;
        }
        if (type == null) {
            if (other.type != null) {
                return false;
            }
        } else if (!type.equals(other.type)) {
            return false;
        }
        return true;
    }

}
