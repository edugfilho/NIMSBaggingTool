package format;

import java.util.ArrayList;

import bagging.feature.FeaturesConsts;

public class TranalyzerOutput extends FlowOutput {

	public TranalyzerOutput() {
		super();
		//Duration is calculated via preprocessing
		featuresPresent.put(FeaturesConsts.flowDuration, 0);
		featuresPresent.put(FeaturesConsts.flowProtocol, 0);
		featuresPresent.put(FeaturesConsts.flowNumPkt, 0);
		featuresPresent.put(FeaturesConsts.flowSz, 0);
		featuresPresent.put(FeaturesConsts.flowMinPktSz, 0);
		featuresPresent.put(FeaturesConsts.flowMaxPktSz, 0);
		featuresPresent.put(FeaturesConsts.flowAvgPktSz, 0);
		featuresPresent.put(FeaturesConsts.flowIpMinTTl, 0);
		featuresPresent.put(FeaturesConsts.flowIpMaxTTL, 0);
		featuresPresent.put(FeaturesConsts.flowIpTTLChg, 0);
		featuresPresent.put(FeaturesConsts.flowTcpInitWinSz, 0);
		featuresPresent.put(FeaturesConsts.flowAvgWinSz, 0);
		featuresPresent.put(FeaturesConsts.flowTcpMinWinSz, 0);
		featuresPresent.put(FeaturesConsts.flowTcpMaxWinSz, 0);
		featuresPresent.put(FeaturesConsts.flowMinIAT, 0);
		featuresPresent.put(FeaturesConsts.flowMaxIAT, 0);
		featuresPresent.put(FeaturesConsts.flowMeanIAT, 0);
		featuresPresent.put(FeaturesConsts.flowMedianIAT, 0);
		featuresPresent.put(FeaturesConsts.flowRangeIAT, 0);
		featuresPresent.put(FeaturesConsts.flowStdIAT, 0);
	}

	@Override
	public String preProcessField(String fieldName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setOutputFlowsFromRawData(ArrayList<Flow> rawData) {
		// TODO Auto-generated method stub
		return null;
	}

}
