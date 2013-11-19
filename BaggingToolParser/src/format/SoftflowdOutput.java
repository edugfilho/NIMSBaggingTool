package format;

import format.FlowOutput.Flow;
import bagging.feature.FeaturesConsts;

public class SoftflowdOutput extends FlowOutput {

	public SoftflowdOutput(){
		featuresPresent.put(FeaturesConsts.flowDuration, 0);
		featuresPresent.put(FeaturesConsts.flowProtocol, 0);
		featuresPresent.put(FeaturesConsts.flowNumPkt, 0);
		featuresPresent.put(FeaturesConsts.flowSz, 0);
		featuresPresent.put(FeaturesConsts.flowTotalFwdPkt, 0);
		featuresPresent.put(FeaturesConsts.flowTotalFwdSz, 0);
		featuresPresent.put(FeaturesConsts.flowTotalBwdPkt, 0);
		featuresPresent.put(FeaturesConsts.flowTotalBwdSz, 0);
		featuresPresent.put(FeaturesConsts.flowPktPerSec, 0);
		featuresPresent.put(FeaturesConsts.flowBytesPerSec, 0);
		featuresPresent.put(FeaturesConsts.flowBytesPerPkt, 0);
		setUsedFeaturesWithCurrentPresentFeatures();




	}

	@Override
	public String preProcessField(String fieldName, Flow f) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSeparator() {
		
		return "";
	}

}
