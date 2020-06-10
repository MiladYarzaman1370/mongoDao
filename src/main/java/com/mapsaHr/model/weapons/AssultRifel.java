package com.mapsaHr.model.weapons;

import com.mapsaHr.cenum.GunBulletCalibr;

public class AssultRifel extends Guns
{
    public AssultRifel(GunBulletCalibr bulletCalibr)
    {
        super(bulletCalibr);
        this.hitRation=50;
        this.damage=10;
        switch (bulletCalibr)
        {
            case Calibr5mm:
                 hitRation+=(hitRation*(15)/100);
                break;
            case Calibr10mm:
                 hitRation+=(hitRation*(-10)/100);
                 damage+=10;
                break;
            default:

        }
    }
    public String getGunType()
    {
        return "AssultRifel";
    }

}
