package script

import com.chm.toodles.lab.groovy.client.OrderSpec
import com.chm.toodles.lab.groovy.client.OrderSpecFilteredDTO
import org.apache.commons.lang3.StringUtils

class OrderSpecHandler {

    OrderSpecFilteredDTO applyRule(String businessCatId, String businessStatus, List<OrderSpec> orderSpecs) {

        if (StringUtils.isBlank(businessCatId) || StringUtils.isBlank(businessStatus) || orderSpecs == null || orderSpecs.isEmpty()) {
            return new OrderSpecFilteredDTO(orderSpecs, null);
        }
        List<OrderSpec> targetOrderSpecs = new ArrayList<>()
        Map<String, Object> extraAttributes = new HashMap<>()
        for (orderSpec in orderSpecs) {
            def code = orderSpec.getSpecCode()
            def name = orderSpec.getSpecName()
            def value = orderSpec.getSpecValue()
            //第一层根据业务类型判断，第二层根据业务状态判断
            switch (businessCatId) {
                case "1501":
                    switch (businessStatus) {
                        case "5":
                            if ("入口时间".equalsIgnoreCase(name)) {
                                OrderSpec targetOrderSpec = new OrderSpec(code, name, value, 0)
                                targetOrderSpecs.add(targetOrderSpec)
                            } else if ("出口时间".equalsIgnoreCase(name)) {
                                OrderSpec targetOrderSpec = new OrderSpec(code, name, value, 1)
                                targetOrderSpecs.add(targetOrderSpec)
                            }
                            break
                        default:
                            break
                    }
                    if ("车道交易流水".equalsIgnoreCase(name)) {
                        extraAttributes.put("laneSN", value)
                    } else if ("虚拟鲁通卡号".equalsIgnoreCase(name)) {
                        extraAttributes.put("discountCardNo", value)
                    }
                    break
                case "1401":
                    switch (businessStatus) {
                        case "5":
                            if ("入口时间".equalsIgnoreCase(name)) {
                                OrderSpec targetOrderSpec = new OrderSpec(code, name, value, 0)
                                targetOrderSpecs.add(targetOrderSpec)
                            } else if ("出口时间".equalsIgnoreCase(name)) {
                                OrderSpec targetOrderSpec = new OrderSpec(code, name, value, 1)
                                targetOrderSpecs.add(targetOrderSpec)
                            }
                            break
                        default:
                            break
                    }
                    if ("车道交易流水".equalsIgnoreCase(name)) {
                        extraAttributes.put("laneSN", value)
                    } else if ("虚拟鲁通卡号".equalsIgnoreCase(name)) {
                        extraAttributes.put("discountCardNo", value)
                    }
                    break
                default:
                    break

            }
        }
        //对筛选的规格进行排序
        if (!targetOrderSpecs.isEmpty()) {
            targetOrderSpecs.sort(Comparator.naturalOrder())
        }
        return new OrderSpecFilteredDTO(targetOrderSpecs, extraAttributes)
    }
}

