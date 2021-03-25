package edu.kpi.testcourse.storage;

import edu.kpi.testcourse.entities.UrlAlias;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Nullable;
import java.util.ArrayList;

/**
 * An in-memory fake implementation of {@link UrlRepository}.
 */
public class UrlRepositoryFakeImpl implements UrlRepository {
  private final HashMap<String, UrlAlias> aliases = new HashMap<>();


  @Override
  public void createUrlAlias(UrlAlias urlAlias) {
    if (aliases.containsKey(urlAlias.alias())) {
      throw new UrlRepository.AliasAlreadyExist();
    }

    aliases.put(urlAlias.alias(), urlAlias);
  }


  @Override
  public @Nullable UrlAlias findUrlAlias(String alias) {
    return aliases.get(alias);
  }


  @Override
  public void deleteUrlAlias (String email, String alias) throws PermissionDenied{
    UrlAlias savedAlias = aliases.get(alias);
    if (savedAlias != null && savedAlias.email().equals(email)) {
      aliases.remove(alias);
    }
    else {
      throw new PermissionDenied();
    }
  }


  @Override
  public List<UrlAlias> getAllAliasesForUser(String userEmail) {
    // TODO: We should implement it
    throw new UnsupportedOperationException();
  }
}
