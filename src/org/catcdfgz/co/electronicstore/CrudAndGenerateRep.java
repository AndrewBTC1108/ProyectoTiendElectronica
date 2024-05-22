package org.catcdfgz.co.electronicstore;

import org.catcdfgz.co.models.Sell;

public interface CrudAndGenerateRep extends CrudProducts, GenerateReports{
    void create(Sell sell);
}
