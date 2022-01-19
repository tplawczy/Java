package shop;

import java.util.ArrayList;
import java.util.List;

import observer.IObserver;
import observer.ISubject;

public class Battery implements Cloneable, ISubject{
	private int charge = 100;
	List<IObserver> iObservers = new ArrayList<>();

	public Battery(int charge) {
		this.charge = charge;
	}

	public int getCharge() {
		return charge;
	}

	public void disCharge(int kilometers) {
		this.charge -= kilometers;
		notifyObservers(charge);
		
	}

	public Object clone() throws CloneNotSupportedException {
		final Battery clonedBattery = (Battery) super.clone();
		clonedBattery.iObservers = new ArrayList<>();
		return clonedBattery;

	}
	public void register(IObserver o) {
        iObservers.add(o);
    }
 
    @Override
    public void unRegister(IObserver o) {
        iObservers.remove(o);
    }
 
    @Override
    public void notifyObservers(int charge) {
    	  for (IObserver iObserver : iObservers) {
    	         iObserver.update(charge);
    	      }
    }

}
