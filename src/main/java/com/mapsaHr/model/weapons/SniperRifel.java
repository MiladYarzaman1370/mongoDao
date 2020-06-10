package com.mapsaHr.model.weapons;

import com.mapsaHr.cenum.GunBulletCalibr;

public class SniperRifel extends Guns
{
    public SniperRifel(GunBulletCalibr bulletCalibr) {
        super(bulletCalibr);
        this.hitRation=60;
        this.damage=20;
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
        return "SniperRifel";
    }
}
