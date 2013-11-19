package bagging.feature;

public class FeaturesConsts {
	public static final String flowSrcIpAddr = "SrcIpAddr";
	public static final String flowDstIpAddr = "DstIpAddr";
	public static final String flowSrcPort = "SrcPort";
	public static final String flowDstPort = "DstPort";
	public static final String flowProtocol = "Protocol";
	
	//TRANALYZER BASED FEATURES
	public static final String flowDuration = "FlowDur";
	public static final String flowNumPkt = "NumOfPkts";
	public static final String flowSz = "FlowSz";
	public static final String flowMinPktSz = "MinPktSize";
	public static final String flowMaxPktSz = "MaxPktSz";
	public static final String flowAvgPktSz = "AvgPktSz";
	public static final String flowIpMinTTl = "IpMinTTL";
	public static final String flowIpMaxTTL = "IpMaxTTL";
	public static final String flowIpTTLChg = "IPTTLChg";
	public static final String flowTcpInitWinSz ="TcpInitWinSz";
	public static final String flowAvgWinSz = "AvgWinSz";
	public static final String flowTcpMinWinSz = "TcpMinWinSz";
	public static final String flowTcpMaxWinSz = "TcpMaxWinSz";
	public static final String flowMinIAT = "MinIAT";
	public static final String flowMaxIAT = "MaxIAT";
	public static final String flowMeanIAT = "MeanIAT";
	public static final String flowMedianIAT = "MedianIAT";
	public static final String flowRangeIAT = "RangeIAT";
	public static final String flowStdIAT = "StdIAT";
	
	//NETMATE BASED FEATURES
	public static final String flowTotalFwdPkt = "TotalFwdPkts";
	public static final String flowTotalFwdSz = "TotalFwdSz";
	public static final String flowTotalBwdPkt = "TotalBwdPkts";
	public static final String flowTotalBwdSz = "TotalBwdSz";
	public static final String flowMinFwdPktSz = "MinFwdPktSz";
	public static final String flowMaxFwdPktSz = "MaxFwdPktSz";
	public static final String flowMeanFwdPktSz = "MeanFwdPktSz";
	public static final String flowStdFwdPktSz = "StdFwdPktSz";
	public static final String flowMinBwdPktSz = "MinBwdPktSz";
	public static final String flowMaxBwdPktSz = "MaxBwdPktSz";
	public static final String flowMeanBwdPktSz = "MeanBwdPktSz";
	public static final String flowStdBwdPktSz = "StdBwdPktSz";
	public static final String flowMinFIAT = "MinFIAT";
	public static final String flowMeanFIAT = "MeanFIAT";
	public static final String flowMaxFIAT ="MaxFIAT";
	public static final String flowStdFIAT = "StdFIAT";
	public static final String flowMinBIAT = "MinBIAT";
	public static final String flowMeanBIAT = "MeanBIAT";
	public static final String flowMaxBIAT = "MaxBIAT";
	public static final String flowStdBIAT = "StdBIAT";
	public static final String flowMinActive = "MinActive";
	public static final String flowMaxActive = "MaxActive";
	public static final String flowMeanActive = "MeanActive";
	public static final String flowStdActive = "StdActive";
	public static final String flowMinIdle = "MinIdle";
	public static final String flowMaxIdle = "MaxIdle";
	public static final String flowStdIdle = "StdIdle";
	public static final String flowSubflowAvgNumFwdPkt = "SubFlowAvgNumFwdPkt";
	public static final String flowSubFlowAvgFwdSz ="SubFlowAvgFwdSz";
	public static final String flowSubflowAvgNumBwdPkt = "SubFlowAvgNumBwdPkt";
	public static final String flowSubFlowAvgBwdSz ="SubFlowAvgBwdSz";
	public static final String flowHeaderFwdTotalSz = "HeaderTotalFwdSz";
	public static final String flowHeaderBwdTotalSz = "HeaderTotalBwdSz";
	
	//NOT USED NETMATE FEATURES
	public static final String flowPshFwdCount = "PshFwdCount";
	public static final String flowPshBwdCount = "PshBwdCount";
	public static final String flowUrgFwdCount = "UrgFwdCount";
	public static final String flowUrgBwdCount = "UrgBwdCount";

	//SOFTFLOWD BASED FEATURES 
	public static final String flowBytesPerSec = "BytesPerSec";
	public static final String flowPktPerSec = "PktPerSec";
	public static final String flowBytesPerPkt = "BytesPerPkt";
	//YAF BASED FEATURES 
	public static final String flowReverseFlowDeltaMiliseconds = "ReverseFlowDeltaMiliseconds";
    
	//NOT USED YAF FEATURES
	public static final String flowStartTime = "StartTime";
	public static final String flowEndTime = "EndTime";
	public static final String flowRtt = "Rtt";
	public static final String flowSrcMacAddr = "SrcMacAddr";
	public static final String flowDestMacAddr = "DestMacAddr";
	public static final String flowFwdIflags = "FwdIflags";
	public static final String flowBwdIflags = "BwdIflags";
	public static final String flowFwdUflags = "FwdUflags";
	public static final String flowBwdUflags = "BwdUflags";
	public static final String flowFwdIsn = "FwdIsn";
	public static final String flowBwdIsn = "BwdIsn";
	public static final String flowFwdTag = "FwdTag";
	public static final String flowBwdTag = "BwdTag";
	public static final String flowAppLabel = "AppLabel";
	public static final String flowEndReason = "EndReason";





	
	
	private FeaturesConsts(){
		//this prevents even the native class from 
	    //calling this ctor as well :
	    throw new AssertionError();
	}
}
