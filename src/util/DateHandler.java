package util;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.util.Properties;

public class DateHandler {
    public static JDatePickerImpl getDatePicker(){
        UtilDateModel model = new UtilDateModel();
        model.setSelected(true);
        Properties p  = new Properties();
        p.put(" text.today "," Today ");
        p.put(" text.month "," Month ");
        p.put(" text.year "," Year ");
        JDatePanelImpl jDatePanel =new JDatePanelImpl(model,p);
        JDatePickerImpl datePicker = new JDatePickerImpl(jDatePanel,new DateLabelFromatter());
        return datePicker;
    }
}
