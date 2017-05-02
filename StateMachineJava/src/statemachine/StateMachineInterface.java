package statemachine;

import java.util.List;

public interface StateMachineInterface<S, I> {
	/**
	 * Add a transition to the state machine, i.e. if in state "start_state" and
	 * token "input" is read, change state to "end_state".
	 */
	void addTransition(S start_state, I input, S end_state);

	/**
	 * Add an accepting end state to the state machine, i.e. if (and only if),
	 * after reading the whole input, the machine is in one of the accepted
	 * states, accepts() should return true.
	 */
	void addAcceptingState(S state);

	/**
	 * Parse the given input, starting in the given state.
	 */
	boolean accepts(S start_state, List<I> input);
}
