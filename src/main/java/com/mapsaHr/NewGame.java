package com.mapsaHr;

import com.mapsaHr.ConstVareable.ConstVareable;
import com.mapsaHr.model.champions.Soldier;

import java.util.ArrayList;

public class NewGame {
    private final int numberOfGroupsMember;
    private ArrayList<Soldier> groupA;
    private ArrayList<Soldier> groupB;
    private Soldier soldierA, soldierB;
    private int indexChampionFromGroupA;
    private int indexChampionFromGroupB;
    public static int tempForIndex=5555;///////////////////////////****************************hard code

    public NewGame(int numberOfMember) {
        this.numberOfGroupsMember = numberOfMember;
        //////////////////////////////////////////temp valu for check...
        indexChampionFromGroupA=tempForIndex;
        indexChampionFromGroupB=tempForIndex;
        creatGroup();
        startMatchs();
        //System.out.println("groupA: "+groupA.size());
        //  System.out.println("groupB: "+groupB.size());
    }


    private void creatGroup() {
        groupA=new ArrayList<Soldier>();
        groupB=new ArrayList<Soldier>();
        Soldier s;
        for(int i=0;i<numberOfGroupsMember;i++)
        {
            s=new Soldier(i);
            groupA.add(s);

            s=new Soldier(i);
            groupB.add(s);

        }
    }

    private void startMatchs() {
        int temp;
        while(groupA.size()>0&&groupB.size()>0)
        {
            /////////////if championA AND CampionB  not Dead  then  not need  select  new soldier   for next fighting.
            if(indexChampionFromGroupA==tempForIndex)
            {
                temp=  RandomHelper.nextInt(groupA.size());
                indexChampionFromGroupA=temp;
            }

            soldierA =groupA.get(indexChampionFromGroupA);
            if(indexChampionFromGroupB==tempForIndex){
                temp=RandomHelper.nextInt(groupB.size());
                indexChampionFromGroupB=temp;

            }

            soldierB =groupB.get(indexChampionFromGroupB);
            System.out.println("//////////////////////////\nA vs B:    id= "+ soldierA.getId()+" -  id="+ soldierB.getId());
            startFight();

            soldierA.getGun().setNumberOfBullet(ConstVareable.NUMBER_OF_BULLET);
            soldierB.getGun().setNumberOfBullet(ConstVareable.NUMBER_OF_BULLET);
            System.out.println("groupA: "+groupA.size());
            System.out.println("groupB: "+groupB.size());

        }
    }

    private void startFight() {
        System.out.println("getGunType     A: " + soldierA.getGun().gunType() + "  B: " + soldierB.getGun().gunType());
        System.out.println("getBulletCalibr     A: " + soldierA.getGun().getGunBulletCalibr() + "  B: " + soldierB.getGun().getGunBulletCalibr());
        System.out.println("getHitRation     A: " + soldierA.getGun().getHitRation() + "  B: " + soldierB.getGun().getHitRation());

        while (soldierA.getGun().getNumberOfBullet() > 0
                && soldierB.getGun().getNumberOfBullet() > 0
                && soldierA.getStamina() > 0 && soldierB.getStamina() > 0) {

            soldierA.attack(soldierB);
            if (soldierB.getStamina() <= 0) {
                groupB.remove(indexChampionFromGroupB);
                indexChampionFromGroupB = tempForIndex;
                System.out.println("**********Shuting and Deads\ngetStamina       A: " + soldierA.getStamina() + "  B: " + soldierB.getStamina());
                System.out.println("getNumberOfBullet     A: " + soldierA.getGun().getNumberOfBullet() + "  B: " + soldierB.getGun().getNumberOfBullet());

                System.out.println("B deads");
                break;
            } else {
            }
             soldierB.attack(soldierA);
            if (soldierA.getStamina() <= 0) {
                groupA.remove(indexChampionFromGroupA);
                indexChampionFromGroupA = tempForIndex;
                System.out.println("**********Shuting with Dead\ngetStamina       A: " + soldierA.getStamina() + "  B: " + soldierB.getStamina());
                System.out.println("getNumberOfBullet     A: " + soldierA.getGun().getNumberOfBullet() + "  B: " + soldierB.getGun().getNumberOfBullet());

                System.out.println("A deads");
                break;
            } else {
            }
            System.out.println("****/////******Shuting withOut Dead\ngetStamina       A: " + soldierA.getStamina() + "  B: " + soldierB.getStamina());
            System.out.println("getNumberOfBullet     A: " + soldierA.getGun().getNumberOfBullet() + "  B: " + soldierB.getGun().getNumberOfBullet());

        }
    }
    }
