package mwm.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class ReportDetail {
	private Long id;
	@ManyToOne
	@JoinColumn(name = "stockId", foreignKey = @ForeignKey(name = "REPORT_DETAIL_STOCK_ID_FK"))
	private Stock stock;
	
	@ManyToOne
	@JoinColumn(name = "reportId", foreignKey = @ForeignKey(name = "REPORT_DETAIL_REPORT_ID_FK"))
	private Report report;
	
	//Static parameters
	private String filter;
	private String sector;
	private float sectorRank;
	private float rawRank;
	private float prevRank;
	private float intrinsicValue;
	private float beta;
	private String PEG;
	private float consensusAnalystForecast;
	private int ups;
	private int downs;
	private String marketCap;
	private String dividendYield;
	private boolean InMomentum;
	private boolean InFlagship1;
	private boolean InFlagship2;
	
	//Calculated stochastic parameters
	private float dailyStochastic14_3;
	private float dailyStochastic5_1;
	private String eligibility;
	private int eligibilityChange;
	
	//Calculated MACD parameters
	private float trendAbsoluteMonthly;
	private float trendRelativeMonthly;
	private float momentumAbsoluteMonthly;
	private float momentumRelativeMonthly;
	private float trendAbsoluteWeekly;
	private float trendRelativeWeekly;
	private float momentumAbsoluteWeekly;
	private float momentumRelativeWeekly;
	private float trendAbsoluteDaily;
	private float trendRelativeDaily;
	private float momentumAbsoluteDaily;
	private float momentumRelativeDaily;

	public ReportDetail() {
		// this form used by Hibernate
	}

	public ReportDetail(Date date, Date timestamp) {
		// for application use, to create new events
	}

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public float getSectorRank() {
		return sectorRank;
	}

	public void setSectorRank(float sectorRank) {
		this.sectorRank = sectorRank;
	}

	public float getRawRank() {
		return rawRank;
	}

	public void setRawRank(float rawRank) {
		this.rawRank = rawRank;
	}

	public float getPrevRank() {
		return prevRank;
	}

	public void setPrevRank(float prevRank) {
		this.prevRank = prevRank;
	}

	public float getIntrinsicValue() {
		return intrinsicValue;
	}

	public void setIntrinsicValue(float intrinsicValue) {
		this.intrinsicValue = intrinsicValue;
	}

	public float getBeta() {
		return beta;
	}

	public void setBeta(float beta) {
		this.beta = beta;
	}

	public String getPEG() {
		return PEG;
	}

	public void setPEG(String pEG) {
		PEG = pEG;
	}

	public float getConsensusAnalystForecast() {
		return consensusAnalystForecast;
	}

	public void setConsensusAnalystForecast(float consensusAnalystForecast) {
		this.consensusAnalystForecast = consensusAnalystForecast;
	}

	public int getUps() {
		return ups;
	}

	public void setUps(int ups) {
		this.ups = ups;
	}

	public int getDowns() {
		return downs;
	}

	public void setDowns(int downs) {
		this.downs = downs;
	}

	public String getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(String marketCap) {
		this.marketCap = marketCap;
	}

	public String getDividendYield() {
		return dividendYield;
	}

	public void setDividendYield(String dividendYield) {
		this.dividendYield = dividendYield;
	}

	public boolean isInMomentum() {
		return InMomentum;
	}

	public void setInMomentum(boolean inMomentum) {
		InMomentum = inMomentum;
	}

	public boolean isInFlagship1() {
		return InFlagship1;
	}

	public void setInFlagship1(boolean inFlagship1) {
		InFlagship1 = inFlagship1;
	}

	public boolean isInFlagship2() {
		return InFlagship2;
	}

	public void setInFlagship2(boolean inFlagship2) {
		InFlagship2 = inFlagship2;
	}

	public float getDailyStochastic14_3() {
		return dailyStochastic14_3;
	}

	public void setDailyStochastic14_3(float dailyStochastic14_3) {
		this.dailyStochastic14_3 = dailyStochastic14_3;
	}

	public float getDailyStochastic5_1() {
		return dailyStochastic5_1;
	}

	public void setDailyStochastic5_1(float dailyStochastic5_1) {
		this.dailyStochastic5_1 = dailyStochastic5_1;
	}

	public String getEligibility() {
		return eligibility;
	}

	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}

	public int getEligibilityChange() {
		return eligibilityChange;
	}

	public void setEligibilityChange(int eligibilityChange) {
		this.eligibilityChange = eligibilityChange;
	}

	public float getTrendAbsoluteMonthly() {
		return trendAbsoluteMonthly;
	}

	public void setTrendAbsoluteMonthly(float trendAbsoluteMonthly) {
		this.trendAbsoluteMonthly = trendAbsoluteMonthly;
	}

	public float getTrendRelativeMonthly() {
		return trendRelativeMonthly;
	}

	public void setTrendRelativeMonthly(float trendRelativeMonthly) {
		this.trendRelativeMonthly = trendRelativeMonthly;
	}

	public float getMomentumAbsoluteMonthly() {
		return momentumAbsoluteMonthly;
	}

	public void setMomentumAbsoluteMonthly(float momentumAbsoluteMonthly) {
		this.momentumAbsoluteMonthly = momentumAbsoluteMonthly;
	}

	public float getMomentumRelativeMonthly() {
		return momentumRelativeMonthly;
	}

	public void setMomentumRelativeMonthly(float momentumRelativeMonthly) {
		this.momentumRelativeMonthly = momentumRelativeMonthly;
	}

	public float getTrendAbsoluteWeekly() {
		return trendAbsoluteWeekly;
	}

	public void setTrendAbsoluteWeekly(float trendAbsoluteWeekly) {
		this.trendAbsoluteWeekly = trendAbsoluteWeekly;
	}

	public float getTrendRelativeWeekly() {
		return trendRelativeWeekly;
	}

	public void setTrendRelativeWeekly(float trendRelativeWeekly) {
		this.trendRelativeWeekly = trendRelativeWeekly;
	}

	public float getMomentumAbsoluteWeekly() {
		return momentumAbsoluteWeekly;
	}

	public void setMomentumAbsoluteWeekly(float momentumAbsoluteWeekly) {
		this.momentumAbsoluteWeekly = momentumAbsoluteWeekly;
	}

	public float getMomentumRelativeWeekly() {
		return momentumRelativeWeekly;
	}

	public void setMomentumRelativeWeekly(float momentumRelativeWeekly) {
		this.momentumRelativeWeekly = momentumRelativeWeekly;
	}

	public float getTrendAbsoluteDaily() {
		return trendAbsoluteDaily;
	}

	public void setTrendAbsoluteDaily(float trendAbsoluteDaily) {
		this.trendAbsoluteDaily = trendAbsoluteDaily;
	}

	public float getTrendRelativeDaily() {
		return trendRelativeDaily;
	}

	public void setTrendRelativeDaily(float trendRelativeDaily) {
		this.trendRelativeDaily = trendRelativeDaily;
	}

	public float getMomentumAbsoluteDaily() {
		return momentumAbsoluteDaily;
	}

	public void setMomentumAbsoluteDaily(float momentumAbsoluteDaily) {
		this.momentumAbsoluteDaily = momentumAbsoluteDaily;
	}

	public float getMomentumRelativeDaily() {
		return momentumRelativeDaily;
	}

	public void setMomentumRelativeDaily(float momentumRelativeDaily) {
		this.momentumRelativeDaily = momentumRelativeDaily;
	}

}