package hello.core.member;

import javax.swing.plaf.metal.MetalMenuBarUI;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
