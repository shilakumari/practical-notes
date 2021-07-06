module com.in28minutes.consumer {
	requires com.in28minutes.service.provider;
	requires java.logging;//for Logger
	//requires transitive java.logging;//If my users also need access, then use 'transitive'.
}