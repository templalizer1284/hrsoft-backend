package dev.aleksandarm.services;

import java.util.List;

import dev.aleksandarm.data.Data_Security;

public interface Service_Security {
	public abstract List<Data_Security> fetch_users();
}
