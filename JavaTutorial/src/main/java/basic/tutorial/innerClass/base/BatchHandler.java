package basic.tutorial.innerClass.base;

import basic.tutorial.innerClass.base.bean.PaymaxResponseData;
import basic.tutorial.innerClass.base.bean.RequestPayData;

public interface BatchHandler {
	
	PaymaxResponseData batchPay(RequestPayData request,BatchHandler paymaxBatchHandler);

}
