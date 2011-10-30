package cq.uqam.mgl7361.analysispatterns.chap2;

import java.util.*;

public class Organization extends Party {
  private Organization parent;

  public Organization (String name, PartyType type) {
    this(name, type, null);
  }
  public Organization (String name, PartyType type, Organization parent) {
    super(name, type);
    setParent(parent);
  }

  public Organization getParent () {
    return parent;
  }
  public void setParent (Organization parent) {
    if (parent != null && parent.getAncestors().contains(this))
      throw new IllegalArgumentException("cannot be an ancestor of self");
    this.parent = parent;
  }

  protected Set<Organization> getAncestors () {
    Set<Organization> ancestors = new HashSet<Organization>();
    if (parent != null) {
      ancestors.add(parent);
      ancestors.addAll(parent.getAncestors());
    }
    return ancestors;
  }
}

// vim:ts=2:sw=2
