package com.mapsaHr.model.champions;

import com.mapsaHr.RandomHelper;
import com.mapsaHr.cenum.GunBulletCalibr;
import com.mapsaHr.cenum.GunType;
import com.mapsaHr.model.weapons.AssultRifel;
import com.mapsaHr.model.weapons.Guns;
import com.mapsaHr.model.weapons.SniperRifel;

public class Soldier
{
    private int id;
    private Guns gun;
    private int stamina;

    public Soldier(int id) {
        this.id = id;
        this.stamina=100;
        selectGun();
    }
    public void attack(Soldier enemy) {
        ////////////////////if The shot is successful
        gun.shoot(enemy);


    }
    private void selectGun()
    {

        int t = 0;
        t += RandomHelper.nextInt(GunType.values().length);
        GunType[] gunTypes=GunType.values();
        //////////show gun type And get response from user
        switch (gunTypes[t])
        {
            case assultRifel:
                gun=new AssultRifel(selectGunBulletCalibr());
                break;
            case sniperRifel:
                gun=new SniperRifel(selectGunBulletCalibr());
                break;
            default:
        }

        ////////show all bulletCaliber foruser


        //return (t % 2) > 0 ? GunBulletCalibr.Calibr10mm : GunBulletCalibr.Calibr5mm;
    }
    private GunBulletCalibr selectGunBulletCalibr()
    {
        int t = 0;

            t += RandomHelper.nextInt(GunBulletCalibr.values().length);

            ////////show all bulletCaliber foruser


        return (t % 2) > 0 ? GunBulletCalibr.Calibr10mm : GunBulletCalibr.Calibr5mm;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Guns getGun() {
        return gun;
    }

    public void setGun(Guns gun) {
        this.gun = gun;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
}
