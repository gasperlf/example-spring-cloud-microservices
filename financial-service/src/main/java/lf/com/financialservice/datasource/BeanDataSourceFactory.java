package lf.com.financialservice.datasource;

import lf.com.financialservice.datasource.alphavantage.AlphaVantage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanDataSourceFactory {

    @Autowired
    private AlphaVantage alphaVantage;

    private BeanDataSourceFactory(){
        super();
    }

    public AlphaVantage getBean(Class<?> classBean){

        if (classBean.equals(AlphaVantage.class)){
            return alphaVantage;
        }
        return null;
    }
}
