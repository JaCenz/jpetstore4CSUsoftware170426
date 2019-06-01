package persistence;

import domain.Sequence;

public interface SequenceDAO {
    Sequence getSequence(Sequence sequence);
    void updateSequence(Sequence sequence);
}
