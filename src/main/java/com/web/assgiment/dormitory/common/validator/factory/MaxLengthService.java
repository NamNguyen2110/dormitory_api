package com.web.assgiment.dormitory.common.validator.factory;





import com.web.assgiment.dormitory.common.utils.CommonUtils;
import com.web.assgiment.dormitory.common.validator.ValidateObject;
import com.web.assgiment.dormitory.common.validator.ValidatorMessage;
import com.web.assgiment.dormitory.common.validator.ValidatorService;
import com.web.assgiment.dormitory.common.validator.exception.FormatInvalidException;
import com.web.assgiment.dormitory.common.validator.group.MaxLengthGroup;
import com.web.assgiment.dormitory.common.validator.group.MessageField;

import java.math.BigDecimal;

public class MaxLengthService implements ValidatorService {

    @Override
    public ValidatorMessage process(ValidateObject object)  throws FormatInvalidException {
        return length(object.getValue(), object.getFieldName(), (MaxLengthGroup)object.getValidatorGroup());
    }

    public static ValidatorMessage length(Object value, String fieldName, MaxLengthGroup group)  throws FormatInvalidException{

        if(value instanceof String) {
            String value1 = (String)value;
            if (!CommonUtils.isEmptyObject(value) && value1.length() > group.getMax()) {
                    return new ValidatorMessage(MessageField.maxLength, fieldName, group.getMax());
                }
        }

        if(value instanceof Long) {
            Long value1 = (Long)value;
            if (!CommonUtils.isEmptyObject(value) && BigDecimal.valueOf(value1).setScale(0).toPlainString().length() > group.getMax()) {
                    return new ValidatorMessage(MessageField.maxLength, fieldName);
                }
        }

        if(value instanceof Integer) {
            Integer value1 = (Integer)value;
            if (!CommonUtils.isEmptyObject(value) &&  BigDecimal.valueOf(value1).setScale(0).toPlainString().length() > group.getMax()) {
                return new ValidatorMessage(MessageField.maxLength, fieldName);
            }
        }


        if(value instanceof BigDecimal) {
            BigDecimal value1 = (BigDecimal)value;
            if (!CommonUtils.isEmptyObject(value) && value1.setScale(0).toPlainString().length() > group.getMax()) {
                    return new ValidatorMessage(MessageField.maxLength, fieldName);
            }
        }

        return null;
    };
}
