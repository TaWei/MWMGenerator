package mwm.entities.helpers;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Embeddable
public class PriceId implements Serializable {
	private Long tickerId;
	private Date date;
	
	public Long getTickerId() {
		return tickerId;
	}

	public void setTickerId(Long tickerId) {
		this.tickerId = tickerId;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(tickerId);
        hcb.append(date);
        return hcb.toHashCode();
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PriceId)) {
            return false;
        }
        PriceId that = (PriceId) obj;
        EqualsBuilder eb = new EqualsBuilder();
        eb.append(tickerId, that.tickerId);
        eb.append(date, that.date);
        return eb.isEquals();
    }
	
}
