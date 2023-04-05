package org.csystem.app.Address;

import org.csystem.app.Account.User;

public class AddressManager {

    public static void addAddress(User user,Address address)
    {
        user.getAddresses().add(address);

    }

    public static void removeAddress(User user)
    {
        user.getAddresses().clear();

    }
}
