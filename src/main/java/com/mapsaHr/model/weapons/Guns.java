
package com.mapsaHr.model.weapons;

import com.mapsaHr.ConstVareable.ConstVareable;
import com.mapsaHr.RandomHelper;
import com.mapsaHr.cenum.GunBulletCalibr;
import com.mapsaHr.model.champions.Soldier;

public abstract class Guns
{
   protected int hitRation;
   protected int damage;
   private GunBulletCalibr gunBulletCalibr;
  private int numberOfBullet;
  private boolean isZommIn;
   Guns()
   {

   }
   Guns(GunBulletCalibr bulletCalibr)
   {
      this.numberOfBullet= ConstVareable.NUMBER_OF_BULLET;
      this.gunBulletCalibr=bulletCalibr;
   }


   public String gunType()
   {
      return "nnnnnnnnnnnn";
   }
   public int getDamage() {
      return damage;
   }

   public void setDamage(int damage) {
      this.damage = damage;
   }

   public GunBulletCalibr getGunBulletCalibr() {
      return gunBulletCalibr;
   }

   public void setGunBulletCalibr(GunBulletCalibr gunBulletCalibr) {
      this.gunBulletCalibr = gunBulletCalibr;
   }

   public int getNumberOfBullet() {
      return numberOfBullet;
   }

   public void setNumberOfBullet(int numberOfBullet) {
      this.numberOfBullet = numberOfBullet;
   }

   public boolean isZommIn() {
      return isZommIn;
   }

   public void setZommIn(boolean zommIn) {
      isZommIn = zommIn;
   }

   public int getHitRation() {
      return hitRation;
   }

   public void setHitRation(int hitRation) {
      this.hitRation = hitRation;
   }

   public  void shoot(Soldier enemy)
   {
       if (checkNumberBulletAndShoting())
       {
           enemy.setStamina(enemy.getStamina() - this.damage);
       }
      // this.gun.setNumberOfBullet(this.gun.getNumberOfBullet() - 1);

   }

    private boolean checkNumberBulletAndShoting() {
        if (this.numberOfBullet > 0) {

                return ShootResult();
        } else {
          return false;
        }
    }

    private boolean ShootResult() {
        int[] hitRatErr = new int[100 - this.hitRation];

        int temp;
        for (int i = 0; i < hitRatErr.length; i++) {
            temp = RandomHelper.nextInt(100) + 1;
            if (!check(hitRatErr, temp)) {
                hitRatErr[i] = temp;
            } else {
                i--;
            }
        }
        temp = RandomHelper.nextInt(100) + 1;
        if (!check(hitRatErr, temp)) {
            return false;
        } else {
            return true;
        }

    }

    private boolean check(int[] hitRatArr, int toCheckValue) {
        boolean test = false;
        for (int element : hitRatArr) {
            if (element == toCheckValue) {
                test = true;
                return test;
            }
        }
        return test;
    }
}


