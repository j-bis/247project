public abstract class ResumeDecorator extends Resume {
    protected Resume resume;

    public ResumeDecorator(Resume resume) {

    }

    public abstract void customize();
}
