package com.aimprosoft.hopak.models;

public enum Gender {
    LESBIAN,
    PANSEXUAL,
    BEE,
    QUEER_PERSONA,
    POLYAMOR,
    ASEXUAL,
    INTERSEX,
    TRANSGENDER,
    GAY,
    STRAIGHT,
    DOUBLESEXUAL;

    @Override
    public String toString() {
        return "Gender{" + this.name() + "}";
    }
}