package com.mapsaHr.cenum;

public enum GunBulletCalibr
{
    Calibr10mm(-10,10),Calibr5mm(15,0);

    private  float EffectOnHitRate;
    private int EffectOnDamage;
    private GunBulletCalibr(int EffectOnHitRate, int EffectOnDamage) {
        this.EffectOnHitRate = EffectOnHitRate;
        this.EffectOnDamage=EffectOnDamage;
        //System.out.println("this.EffectOnRate:"+ this.EffectOnRate);
    }
    public float EffectOnRate()
    {
        return this.EffectOnHitRate /100;
    }
    public int EffectOnDamage()
    {
        return this.EffectOnDamage;
    }
}
