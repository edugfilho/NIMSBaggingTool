package database;

import bagging.feature.FeaturesConsts;

public class TranalyzerBagging {

	String baggingQuery;

	public TranalyzerBagging(){
		baggingQuery = 
				"SELECT "+FeaturesConsts.flowSrcIpAddr+", "+FeaturesConsts.flowDstIpAddr+", "
						+FeaturesConsts.flowSrcPort+", "+FeaturesConsts.flowDstPort+"," +
						"COUNT(Orders.OrderID) AS NumberOfOrders FROM flows " +
								"GROUP BY ShipperName";
						
				
				//TODO SUBTRACT first packet start time from last packet end time in SELECT
				

"
	}
	/*
	 * Tranalyzer bagging features:
	 * 
	 * Total duration (last packet end time - first packet start time)
	 * 
	 * max Duration ,min Duration, Average Duration, Std of Duration
	 * 
	 * Layer 4 Protocol
	 * 
	 * Total Number of packets
	 * 
	 * Min , Max , Average and Std of Number of Packets
	 * 
	 * Total Number of Bytes
	 * 
	 * Min , Max , Average and Std of Number of Bytes
	 * 
	 * Min of minPktSz, Max of maxPktSz
	 * 
	 * Average of avePktSize
	 * 
	 * Min of ipMinTTL
	 * 
	 * Max of ipMxTTL,
	 * 
	 * Overall ipTTLChg
	 * 
	 * Min of tcpInitWinSz and Max of tcpInitWinSz
	 * 
	 * Average of AveWinSz
	 * 
	 * Min of tcpMinWinSz
	 * 
	 * Max of tcpMaxWinSz
	 * 
	 * Min of MinIat
	 * 
	 * Max of MaxIat
	 * 
	 * Average of MeanIat
	 * 
	 * median of MedianIat
	 * 
	 * Max, Min, Average and Std of RangeIat
	 * 
	 * Std of StdIat
	 */

}
