package statemachine;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class StateMachine<S, I> implements StateMachineInterface<S, I> {

	/*
	 * Please add your implementation here!
	 */
private List<S> m_AccStates;
private Hashtable<S, Hashtable<I,S>> m_Succ;


public StateMachine(){
	m_AccStates = new ArrayList<S>();
	m_Succ = new Hashtable<S, Hashtable<I,S>>();
}

@Override
public void addTransition(S start_state, I input, S end_state) {
	if(!m_Succ.containsKey(start_state)){
		Hashtable<I,S> temphash = new Hashtable<I,S>();
		
		m_Succ.put(start_state, temphash);
	}	

		m_Succ.get(start_state).put(input, end_state);
	
	
}

@Override
public void addAcceptingState(S state) {
	if(!m_AccStates.contains(state))
		m_AccStates.add(state);
	
}

@Override
public boolean accepts(S start_state, List<I> input) {
	// TODO Auto-generated method stub
	S temp = start_state;
	
	for(int i = 0; i < input.size(); i++){
		if(!m_Succ.containsKey(temp))
			return false;
		if(!m_Succ.get(temp).containsKey(input.get(i)))
			return false;
		else{
			temp = m_Succ.get(temp).get(input.get(i));
		}
	}
	if(m_AccStates.contains(temp))
		return true;
	else
		return false;
}

}
